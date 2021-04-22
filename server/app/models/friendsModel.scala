package models

import models.Tables._
import slick.backend.DatabaseConfig
import slick.jdbc.JdbcProfile
import slick.jdbc.JdbcBackend.Database



import slick.jdbc.PostgresProfile.api._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext

class friendsModel(db: Database)(implicit ec: ExecutionContext) {
  //   def validateUser(username: String, password: String): Future[Option[Int]] = {
  //   val matches = db.run(Users.filter(userRow => userRow.username === username).result)
  //   matches.map(userRows => userRows.headOption.flatMap {
  //     userRow => if (password == userRow.password) Some(userRow.userId) else None
  //   })
  // }
  
  // def createUser(username: String, password: String): Future[Option[Int]] = {
  //   val matches = db.run(Users.filter(userRow => userRow.username === username).result)
  //   matches.flatMap { userRows =>
  //     if (userRows.isEmpty) {
  //       db.run(Users += UsersRow(-1, Some(username), Some(password)))
  //         .flatMap { addCount => 
  //           if (addCount > 0) db.run(Users.filter(userRow => userRow.username === username).result)
  //             .map(_.headOption.map(_.userId))
  //           else Future.successful(None)
  //         }
  //     } else Future.successful(None)
  //   }
  // }
  // //  case class RelationshipsRow(relationshipId: Int, user1Id: Int, user2Id: Int, relationshipTypeId: Int)
  // def getRelationships(username: String): Future[Seq[(RelationshipsRow)]] = {
  //    //ASSUME USER EXISTS
  //   val thingToRun = Users.filter(userRow => userRow.username === username).result.head.userId
  //   val userID = db.run(thingToRun) //crashes if the user doesnt exist
  //   val secondThingToRun =
  //   db.run(Relationships.filter(relationshipRow => relationshipRow.user1Id === userID).result)

  // }
  
  // def addTask(userid: Int, task: String): Future[Int] = {
  //   db.run(Items += ItemsRow(-1, userid, task))
  // }
  
  // def removeTask(itemId: Int): Future[Boolean] = {
  //   db.run( Items.filter(_.itemId === itemId).delete ).map(count => count > 0)
  // }
}