import dispatch.{Req, host}
import org.asynchttpclient.Request

case class ProvidersRequest(groups: Some[String]) {
  private val baseHost = host("www.tinkoff.ru").secure
  private val request = baseHost / "api" / "v1" / "providers"
  def requestWithParams: Request = {
    request.addQueryParameter("groups", groups.get).toRequest
  }
}
