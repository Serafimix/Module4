package ua.rakhmail;

import ua.rakhmail.dao.RaceDao;
import ua.rakhmail.utils.HibernateChanger;


public class Main {

    /**
     * Перед ПЕРВЫМ стартом сервера на компьютере необходимо ОДИН РАЗ:
     * 1. В файле hibernate.cfg.xml поменять необходимые входные данные базы данных на свои
     * ( особенно внимательно смотрим на имя БД и меняем на свое)
     * 2. Далее можно запускать сервер через плагин tomcat7 -> run. и переходить по ссылке на http://localhost:8080/
     * <p>
     * <p>
     * <p>
     * <p>
     * В случае ошибки первого запуска, так же можно:
     * 1. В текстовом файле по пути src/main/resources/codeForHibernateChange также меняем соответствующие поля имени БД.
     * 2. В Файле src/main/resources/hibernate.cfg.xml в строчке 20 активировать
     * <property name="hibernate.hbm2ddl.auto">create-drop</property>-->, у брав в коментарии 19-ю строчку соответственно.
     * 3. Запустить мейн в клссе Main для создания первичных данных в БД.
     * 4. Далее можно запускать сервер через плагин tomcat7 -> run. и переходить по ссылке на http://localhost:8080/
     */

    public static void main(String[] args) {
        HibernateChanger hibernateChanger = new HibernateChanger();
        hibernateChanger.change();
    }
}
