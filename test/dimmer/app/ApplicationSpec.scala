package dimmer.app

import org.scalatestplus.play._

import play.api.mvc._
import play.api.test._
import play.api.test.Helpers._

import scala.concurrent.Future

class ApplicationSpec extends PlaySpec with Results {

  "health check should return ok" in {

    val controller = new Application()
    val result: Future[Result] = controller.healthCheck().apply(FakeRequest(GET, "/healthcheck"))
    val bodyText: String = contentAsString(result)
    bodyText mustBe "Ok"
  }

  "Application" should {

    "render the index page" in {
      val controller = new Application()
      val result: Future[Result] = controller.index().apply(FakeRequest(GET, "/"))

      status(result) mustBe OK
      contentType(result) mustBe Some("text/plain")
      contentAsString(result) mustBe "Your new application is ready."
    }
  }

}