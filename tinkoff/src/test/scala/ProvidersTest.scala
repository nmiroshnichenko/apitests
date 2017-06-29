import org.scalatest.{FlatSpec, GivenWhenThen}
import play.api.libs.json.{JsArray, JsValue}
import org.scalactic.Snapshots._

class ProvidersTest extends FlatSpec with GivenWhenThen {

  "Providers" should "return ok from ANONYMOUS with groups" in {
    When("I perform providers")
    val model = new ProvidersModel(ProvidersRequest(groups = Some("Переводы")))
    model.fire()
    info(s"$model")
    Then("I expect status in 2xx")
    assert(model.checkResult(), snap(model.globResult))
    Then("I expect doc is JSON")
    assert(model.responseModel.isInstanceOf[JsValue], snap(model))
    Then("I expect resultCode is OK")
    assert((model.responseModel \ "resultCode").asOpt[String].contains("OK"), snap(model))
    Then("I expect all groupId is Переводы")
    (model.responseModel \\ "groupId").foreach(x => {
      assert(x.as[String] == "Переводы", snap(model))
    })
    Then("I expect name is Фамилия плательщика where id is lastName")
    (model.responseModel \\ "providerFields").foreach(x => {
      x.as[JsArray].value.foreach(y => {if((y \ "id").asOpt[String].contains("lastName")){
        assert((y \ "name").asOpt[String].getOrElse("None").contains("Фамилия"), snap(y))
      }})
    })
  }
}
