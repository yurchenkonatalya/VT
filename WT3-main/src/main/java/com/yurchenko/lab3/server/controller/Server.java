package com.labovichl.lab3.server.controller;

import com.labovichl.lab3.connection.Message;
import com.labovichl.lab3.connection.MessageType;
import com.labovichl.lab3.scanner.ScanTool;
import com.labovichl.lab3.connection.Connection;
import com.labovichl.lab3.server.entity.Role;
import com.labovichl.lab3.server.entity.StudentInfo;
import com.labovichl.lab3.server.entity.User;
import com.labovichl.lab3.server.exeptions.ServiceException;
import com.labovichl.lab3.server.service.ServiceFactory;
import com.labovichl.lab3.server.service.description.StudentInfoService;
import com.labovichl.lab3.server.service.description.UserService;
import com.labovichl.lab3.server.service.validator.Validator;
import com.labovichl.lab3.server.service.validator.ValidatorFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;

public class Server {
    private ServerSocket serverSocket;
    private static volatile boolean isServerStart = false;

    public static void main(String[] args) {
        Server server = new Server();


        while (true) {
            System.out.println("Введите номер порта (1025-65536) для запуска сервера");
            int port= ScanTool.scanPositiveNumberInRange(1025,65535);
            if(port==-1){
                System.out.println("Неверный номер порта");
            }else {
                server.startServer(port);
            }
            if (isServerStart) {
                server.acceptServer();
                isServerStart = false;
            }
        }
    }

    protected void startServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            isServerStart = true;
            System.out.println("Сервер запущен.");
            try {
                InetAddress address=InetAddress.getLocalHost();
                System.out.println("Адрес сервера для подключения: "+address.getHostAddress()+":"+port);
            } catch (UnknownHostException e) {
                System.out.println("Не удалось узнать адрес сервера");
            }
        } catch (Exception e) {
            System.out.println("Не удалось запустить сервер.");
        }
    }

    protected void acceptServer() {
        while (true) {

            try {
                Socket socket=serverSocket.accept();
                new ServerThread(socket).start();
            } catch (IOException e) {
                System.out.println("Ошибка подключения пользователя");
            }


        }
    }


    private class ServerThread extends Thread {
        private Socket socket;
        private UserService userService;
        private StudentInfoService studentInfoService;
        private Role role;

        public ServerThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("Подключился новый пользователь с удаленным сокетом: "+socket.getRemoteSocketAddress());

            try {
                Connection connection  = new Connection(socket);
                receiveMessageFromUser(connection);

            } catch (IOException e) {
                e.printStackTrace();
            }



        }

        private void receiveMessageFromUser(Connection connection){
            boolean isUserConnect=true;
             userService= ServiceFactory.getInstance().getUserService();
             studentInfoService=ServiceFactory.getInstance().getStudentInfoService();
            while (isUserConnect){
                try {
                    Message message=connection.receive();


                    if(message.getTypeMessage()== MessageType.LOGIN){
                        Validator validator=ValidatorFactory.getInstance().getLoginPasswordValidator();
                        if(validator.isValid(message.getTextMessage())){
                            if(IsLogIn(message.getTextMessage())){
                                connection.send(new Message(MessageType.LOGIN_SUCCESS));
                            }else {
                                connection.send(new Message(MessageType.LOGIN_ERROR,"Неверный логин или пароль"));
                            }
                        }else{
                            connection.send(new Message(MessageType.LOGIN_ERROR,
                                    "Ошибка валидации"));
                        }

                    }

                    if(message.getTypeMessage()==MessageType.SELECT_ALL_STUDENTS_INFO){
                        connection.send(new Message(MessageType.SELECT_ALL_STUDENTS_INFO_SUCCESS, takeAllStudentsInfo()));
                    }

                    if(message.getTypeMessage()==MessageType.SELECT_STUDENTS_INFO_BY_SPECIALITY){
                            connection.send(new Message(MessageType.SELECT_STUDENTS_INFO_BY_SPECIALITY_SUCCESS,
                                    takeStudentInfoBySpeciality(message.getTextMessage())));

                    }

                    if(message.getTypeMessage()==MessageType.SELECT_STUDENT_INFO_BY_GRADE_BOOK_NUMBER){
                        Validator validator= ValidatorFactory.getInstance().getGradeBookValidator();
                        if(validator.isValid(message.getTextMessage())){
                            connection.send(new Message(MessageType.SELECT_STUDENT_INFO_BY_GRADE_BOOK_NUMBER_SUCCESS,
                                    takeStudentInfoByByBookGradeNumber(message.getTextMessage())));
                        }else {
                            connection.send(new Message(MessageType.SELECT_STUDENT_INFO_BY_GRADE_NUMBER_ERROR,
                                    "Ошибка валидации"));
                        }
                    }



                    if(message.getTypeMessage()==MessageType.SAVE_STUDENT_INFO){
                        if(role==Role.ADMIN){
                            Validator validator= ValidatorFactory.getInstance().getStudentInfoValidator();
                            if(validator.isValid(message.getTextMessage())){
                                connection.send(new Message(MessageType.SAVE_STUDENT_INFO_SUCCESS,
                                        saveStudentInfoB(message.getTextMessage())));
                            }else {
                                connection.send(new Message(MessageType.SAVE_STUDENT_INFO_ERROR,
                                        "Ошибка валидации"));
                            }
                        }else {
                            connection.send(new Message(MessageType.SAVE_STUDENT_INFO_ERROR,
                                    "У вас недостаточно прав для этого"));
                        }

                    }

                    if(message.getTypeMessage()==MessageType.UPDATE_STUDENT_INFO_BY_GRADE_BOOK_NUMBER){
                        if(role==Role.ADMIN){
                            Validator validator= ValidatorFactory.getInstance().getUpdateStudentInfoValidator();
                            if(validator.isValid(message.getTextMessage())){
                                connection.send(new Message(MessageType.UPDATE_STUDENT_INFO_BY_GRADE_BOOK_NUMBER_SUCCESS,
                                        updateStudentInfoByBookGradeNumber(message.getTextMessage())));
                            }else {
                                connection.send(new Message(MessageType.UPDATE_STUDENT_INFO_BY_GRADE_BOOK_NUMBER_ERROR,
                                        "Ошибка валидации"));
                            }
                        }else {
                            connection.send(new Message(MessageType.UPDATE_STUDENT_INFO_BY_GRADE_BOOK_NUMBER_ERROR,
                                    "У вас недостаточно прав для этого"));
                        }

                    }

                    if(message.getTypeMessage()==MessageType.DISCONNECT_FROM_SERVER){
                        connection.close();
                        isUserConnect=false;
                    }


                } catch (IOException e) {
                    System.out.println("Ошибка при приеме/отправке сообщения клиента");
                    isUserConnect=false;
                    try {
                        connection.close();
                    } catch (IOException ioException) {
                        System.out.println("Не удалось закрыть соединение");
                    }
                } catch (ClassNotFoundException e) {
                    System.out.println("Класс сериализуемого объекта не найден");
                }
            }
        }


        private boolean IsLogIn(String loginPassword){
            boolean result=false;
            String[] data=loginPassword.split(":");
            try {
                Optional<User> user=userService.login(data[0],data[1]);
                if(user.isPresent()){
                    role=user.get().getRole();
                    result=true;
                }
            } catch (ServiceException e) {
                System.out.println("Ошибка поиска пользователя");
            }
            return result;
        }

        private String takeAllStudentsInfo(){
            String result="Не обнаружена инвормация о студентах";
            try {
                List<StudentInfo> allStudentInfo=studentInfoService.findAll();
                if(!(allStudentInfo==null)){
                    StringBuffer temp=new StringBuffer();
                    for (int i = 0; i <allStudentInfo.size(); i++) {
                        temp.append(allStudentInfo.get(i)).append("\n");
                    }
                    result=temp.toString();
                }
            } catch (ServiceException e) {
                System.out.println("Ошибка при поиске информации о всех студентах");
            }
            return result;
        }

        private String takeStudentInfoBySpeciality(String speciality){
            String result="Не обнаружена инвормация о студентах";
            try {
                List<StudentInfo> studentsInfo=studentInfoService.findBySpeciality(speciality);
                if(!(studentsInfo==null)){
                    StringBuffer temp=new StringBuffer();
                    for (int i = 0; i <studentsInfo.size(); i++) {
                        temp.append(studentsInfo.get(i)).append("\n");
                    }
                    result=temp.toString();
                }
            } catch (ServiceException e) {
                System.out.println("Ошибка при поиске информации о  студентах");
            }
            return result;
        }

        private String takeStudentInfoByByBookGradeNumber(String number){
            String result="Не обнаружена информация о студенте";
            try {
                Optional<StudentInfo> studentsInfo=studentInfoService.findByGradeBookNumber(number);
                if(studentsInfo.isPresent()){
                    result=studentsInfo.get().toString();
                }
            } catch (ServiceException e) {
                System.out.println("Ошибка при поиске информации о  студенте");
            }
            return result;
        }

        private String saveStudentInfoB(String studentInfo){

            String result="Информация о студенте сохранена";
            String[] data=studentInfo.split(":");
            try {
                studentInfoService.saveStudentInfo(data[0],data[1],data[2],data[3],data[4],data[5],data[6]);
            } catch (ServiceException e) {
                System.out.println("Ошибка при сохранении информации о студенте");
            }
            return result;
        }

        private String updateStudentInfoByBookGradeNumber(String studentInfo){
            String result="Информация о студенте обновлена";
            String[] data=studentInfo.split(":");
            try {
                studentInfoService.updateStudentInfoByGradeBookNumber(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7]);
            } catch (ServiceException e) {
                System.out.println("Ошибка при обновлении информации о студенте");
            }
            return result;
        }



    }
}
