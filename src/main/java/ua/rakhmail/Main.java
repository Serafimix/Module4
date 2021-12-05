package ua.rakhmail;

import ua.rakhmail.utils.HibernateChanger;


public class Main {

    /**
     * Перед ПЕРВЫМ стартом сервера на компютере необходимо ОДИН РАЗ:
     * 1. В файле hibernate.cfg.xml поменять необходимые входные данные базы данных на свои
     * ( особенно внимательно смотрим на имя БД и меняем на свое)
     * 2. В текстовом файле по пути src/main/resources/codeForHibernateChange также меняем соответствующие поля имени БД.
     * 3. Запустить мейн в клссе Main для создания первичных данных в БД.
     * 4. Далее можно запускать сервер через плагин tomcat7 -> run. и переходить по ссылке на http://localhost:8080/
     */

    public static void main(String[] args) {
        HibernateChanger hibernateChanger = new HibernateChanger();
        hibernateChanger.change();
    }
}
