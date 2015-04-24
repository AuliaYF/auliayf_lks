/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auliayf.app.lks.core;

import java.util.ArrayList;

/**
 *
 * @author RPL-03 student
 */
public class DB_Query {

    private String mTable;
    private final ArrayList<String> mSelects = new ArrayList<>();
    private final ArrayList<String[]> mJoins = new ArrayList<>();
    private final ArrayList<String[]> mWheres = new ArrayList<>();
    private final ArrayList<String[]> mLikes = new ArrayList<>();

    public DB_Query(String table) {
        this.mTable = table;
    }

    public DB_Query select(String... selects) {
        for (String select : selects) {
            this.mSelects.add(select);
        }
        return this;
    }

    public DB_Query join(String table, String args, String type) {
        this.mJoins.add(new String[]{table, args, type});
        return this;
    }

    public DB_Query where(String type, String args) {
        this.mWheres.add(new String[]{type, args});
        return this;
    }

    public DB_Query like(String type, String field, String args) {
        this.mLikes.add(new String[]{type, field, args});
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (this.mSelects.size() > 0) {
            builder.append("SELECT ");

            boolean first = true;
            for (String select : this.mSelects) {
                if (!first) {
                    builder.append(", ");
                }

                builder.append(select);
                first = false;
            }

            builder.append(" FROM ").append(mTable);
        }

        if (this.mJoins.size() > 0) {
            for (String[] join : this.mJoins) {
                builder.append(join[2]).append(" JOIN ").append(join[0]);

                builder.append(" ON ").append(join[1]);
            }
        }

        if (this.mWheres.size() > 0) {
            builder.append(" WHERE ");
            boolean first = true;
            for (String[] where : this.mWheres) {
                if (!first) {
                    builder.append(" ").append(where[0]).append(" ");
                }

                builder.append(where[1]);
                first = false;
            }
        }

        if (this.mLikes.size() > 0) {
            builder.append(" ");
            boolean first = true;
            for (String[] like : this.mLikes) {
                if (!first) {
                    builder.append(" ").append(like[0]).append(" ");
                } else {
                    if (this.mWheres.size() > 0) {
                        builder.append(like[0]).append(" ");
                    }
                }

                builder.append(like[1]).append(" LIKE ").append('"').append(like[2]).append('"');
                first = false;
            }
        }
        return builder.toString();
    }
}
