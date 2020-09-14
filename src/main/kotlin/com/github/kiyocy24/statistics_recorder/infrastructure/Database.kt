package com.github.kiyocy24.statistics_recorder.infrastructure

import com.github.kiyocy24.statistics_recorder.warning
import com.github.kiyocy24.statistics_recorder.entity.db.User as dbUser
import java.sql.Connection
import java.sql.SQLException

class Database(private val conn: Connection) {
    fun create() {
        try {
            conn.prepareStatement(CREATE_USERS).executeUpdate()
            conn.prepareStatement(CREATE_ITEM_LOGS).executeUpdate()
        } catch (e: SQLException) {
            warning(e.message)
        }
    }

    inner class User {
        fun searchByUuid(uuid: String) : dbUser {
            var user = dbUser()
            try {
                val sql = "SELECT * from users WHERE uuid=?"
                val pstmt = conn.prepareStatement(sql)
                pstmt.setString(1, uuid)
                val rs = pstmt.executeQuery()

                if (rs.next()) {
                    user = dbUser(
                            id = rs.getInt("id"),
                            uuid = rs.getString("uuid"),
                            name = rs.getString("name"),
                            lastLogin = rs.getTimestamp("last_login"),
                            createdAt = rs.getTimestamp("created_at"),
                            updatedAt = rs.getTimestamp("updated_at")
                    )
                }
                rs.close()
                pstmt.close()
            } catch (e: SQLException) {
                warning(e.message)
            }
            return user
        }

        fun insert(u: dbUser) {
            try {
                val sql = "INSERT INTO users (uuid, name, last_login) values (?, ?, ?)"
                val pstmt = conn.prepareStatement(sql)
                pstmt.setString(1, u.uuid)
                pstmt.setString(2, u.name)
                pstmt.setTimestamp(3, u.lastLogin)
                pstmt.executeUpdate()
                pstmt.close()
            } catch (e: SQLException) {
                warning(e.message)
            }
        }

        fun update(u: dbUser) {
            try {
                val sql = "UPDATE users SET name=?, last_login=? WHERE uuid = ?"
                val pstmt = conn.prepareStatement(sql)
                pstmt.setString(1, u.name)
                pstmt.setTimestamp(2, u.lastLogin)
                pstmt.setString(3, u.uuid)
                pstmt.executeUpdate()
                pstmt.close()
            } catch (e: SQLException) {
                e.stackTrace
                warning(u.name)
                warning(u.uuid)
                warning(u.lastLogin.toString())
                warning(e.message)
            }
        }
    }
}