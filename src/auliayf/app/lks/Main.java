/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auliayf.app.lks;

import auliayf.app.lks.core.DB_Query;

/**
 *
 * @author RPL-03 student
 */
public class Main {

    public static void main(String[] args) {
        DB_Query query = new DB_Query("user");
        query.select("nama", "level.level");
        query.join("level", "level.id = user.level", "");
        query.where("OR", "user.id = 3");
        query.where("AND", "user.id = 4");
        query.like("OR", "user", "%A");
        query.like("AND", "user", "A%");
        System.out.println(query.toString());
    }
}
