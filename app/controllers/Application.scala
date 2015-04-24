package controllers

import play.api.mvc._
import play.twirl.api.HtmlFormat

object Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  def uploadFile = Action(parse.multipartFormData) { request =>
    request.body.file("fileUpload").map { file =>
      val videoFilename = file.filename
      val contentType = file.contentType.get

      // Move file to folder
      // file.ref.moveTo(new File("D:\\TEMP\\" + file.filename))

      val fileInsides = HtmlFormat.escape(scala.io.Source.fromFile(file.ref.file).mkString)
        .toString()
        .replace(32.toChar.toString, "&nbsp;")
        .replace(9.toChar.toString, "&nbsp;&nbsp;&nbsp;&nbsp;")
        .replace(10.toChar.toString, "<br />")

      Ok("File has been uploaded: " + file.filename + "<br />" + "It's content: " + "<br /><br />" +
        fileInsides)

    }.getOrElse {
      Ok("Error during uploading")
    }
  }
}