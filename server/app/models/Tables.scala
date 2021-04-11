package models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.PostgresProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Relationships.schema ++ RelationshipTypes.schema ++ Users.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Relationships
   *  @param relationshipId Database column relationship_id SqlType(serial), AutoInc, PrimaryKey
   *  @param user1Id Database column user1_id SqlType(int4)
   *  @param user2Id Database column user2_id SqlType(int4)
   *  @param relationshipTypeId Database column relationship_type_id SqlType(int4) */
  case class RelationshipsRow(relationshipId: Int, user1Id: Int, user2Id: Int, relationshipTypeId: Int)
  /** GetResult implicit for fetching RelationshipsRow objects using plain SQL queries */
  implicit def GetResultRelationshipsRow(implicit e0: GR[Int]): GR[RelationshipsRow] = GR{
    prs => import prs._
    RelationshipsRow.tupled((<<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table relationships. Objects of this class serve as prototypes for rows in queries. */
  class Relationships(_tableTag: Tag) extends profile.api.Table[RelationshipsRow](_tableTag, "relationships") {
    def * = (relationshipId, user1Id, user2Id, relationshipTypeId) <> (RelationshipsRow.tupled, RelationshipsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(relationshipId), Rep.Some(user1Id), Rep.Some(user2Id), Rep.Some(relationshipTypeId))).shaped.<>({r=>import r._; _1.map(_=> RelationshipsRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column relationship_id SqlType(serial), AutoInc, PrimaryKey */
    val relationshipId: Rep[Int] = column[Int]("relationship_id", O.AutoInc, O.PrimaryKey)
    /** Database column user1_id SqlType(int4) */
    val user1Id: Rep[Int] = column[Int]("user1_id")
    /** Database column user2_id SqlType(int4) */
    val user2Id: Rep[Int] = column[Int]("user2_id")
    /** Database column relationship_type_id SqlType(int4) */
    val relationshipTypeId: Rep[Int] = column[Int]("relationship_type_id")
  }
  /** Collection-like TableQuery object for table Relationships */
  lazy val Relationships = new TableQuery(tag => new Relationships(tag))

  /** Entity class storing rows of table RelationshipTypes
   *  @param relationshipTypeId Database column relationship_type_id SqlType(serial), AutoInc, PrimaryKey
   *  @param description Database column description SqlType(bpchar), Length(50,false) */
  case class RelationshipTypesRow(relationshipTypeId: Int, description: String)
  /** GetResult implicit for fetching RelationshipTypesRow objects using plain SQL queries */
  implicit def GetResultRelationshipTypesRow(implicit e0: GR[Int], e1: GR[String]): GR[RelationshipTypesRow] = GR{
    prs => import prs._
    RelationshipTypesRow.tupled((<<[Int], <<[String]))
  }
  /** Table description of table relationship_types. Objects of this class serve as prototypes for rows in queries. */
  class RelationshipTypes(_tableTag: Tag) extends profile.api.Table[RelationshipTypesRow](_tableTag, "relationship_types") {
    def * = (relationshipTypeId, description) <> (RelationshipTypesRow.tupled, RelationshipTypesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(relationshipTypeId), Rep.Some(description))).shaped.<>({r=>import r._; _1.map(_=> RelationshipTypesRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column relationship_type_id SqlType(serial), AutoInc, PrimaryKey */
    val relationshipTypeId: Rep[Int] = column[Int]("relationship_type_id", O.AutoInc, O.PrimaryKey)
    /** Database column description SqlType(bpchar), Length(50,false) */
    val description: Rep[String] = column[String]("description", O.Length(50,varying=false))
  }
  /** Collection-like TableQuery object for table RelationshipTypes */
  lazy val RelationshipTypes = new TableQuery(tag => new RelationshipTypes(tag))

  /** Entity class storing rows of table Users
   *  @param userId Database column user_id SqlType(serial), AutoInc, PrimaryKey
   *  @param username Database column username SqlType(bpchar), Length(50,false), Default(None)
   *  @param password Database column password SqlType(bpchar), Length(50,false), Default(None) */
  case class UsersRow(userId: Int, username: Option[String] = None, password: Option[String] = None)
  /** GetResult implicit for fetching UsersRow objects using plain SQL queries */
  implicit def GetResultUsersRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[UsersRow] = GR{
    prs => import prs._
    UsersRow.tupled((<<[Int], <<?[String], <<?[String]))
  }
  /** Table description of table users. Objects of this class serve as prototypes for rows in queries. */
  class Users(_tableTag: Tag) extends profile.api.Table[UsersRow](_tableTag, "users") {
    def * = (userId, username, password) <> (UsersRow.tupled, UsersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(userId), username, password)).shaped.<>({r=>import r._; _1.map(_=> UsersRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column user_id SqlType(serial), AutoInc, PrimaryKey */
    val userId: Rep[Int] = column[Int]("user_id", O.AutoInc, O.PrimaryKey)
    /** Database column username SqlType(bpchar), Length(50,false), Default(None) */
    val username: Rep[Option[String]] = column[Option[String]]("username", O.Length(50,varying=false), O.Default(None))
    /** Database column password SqlType(bpchar), Length(50,false), Default(None) */
    val password: Rep[Option[String]] = column[Option[String]]("password", O.Length(50,varying=false), O.Default(None))
  }
  /** Collection-like TableQuery object for table Users */
  lazy val Users = new TableQuery(tag => new Users(tag))
}
