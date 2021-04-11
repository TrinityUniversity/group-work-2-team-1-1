package models

object CodeGen extends App {
  slick.codegen.SourceCodeGenerator.run(
    "slick.jdbc.PostgresProfile", 
    "org.postgresql.Driver",
    "jdbc:postgresql://localhost/postgres?user=cweisenb&password=password",
    """C:\Users\flyin\Documents\GitHub\group\server\app\""", 
    "models", None, None, true, false
  )
}