import java.util.concurrent.CompletableFuture

import dispatch.Http
import org.asynchttpclient.Response
import play.api.libs.json.{JsValue, Json}
import org.scalactic._
import TypeCheckedTripleEquals._

class ProvidersModel(providersRequest: ProvidersRequest) {
  def globResult: Int = responseFuture.get().getStatusCode

  def checkResult(): Boolean = globResult === 200

  def responseModel: JsValue = Json.parse(responseFuture.get().getResponseBody)


  var responseFuture = new CompletableFuture[Response]

  def fire(): Unit = {
    val response = Http.default.client.executeRequest(providersRequest.requestWithParams)
      .toCompletableFuture.get()
    responseFuture.obtrudeValue(response)
  }
}
