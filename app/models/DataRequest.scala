package models

case class DataReq(id: Int, title: String, firstName: String, lastName: String) {
  def fullName = firstName + " " + lastName
}
case class DataRequest(id: Int, userId: Long, title: String, description: String)
