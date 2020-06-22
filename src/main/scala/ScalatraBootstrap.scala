import com.example.app._
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    val keys = collection.mutable.Map[Integer, String]()
    val similar_tracks_ids = collection.mutable.Map[Integer, String]()
    val client_id:String = "XXXXXXXXXXXXXXXXXXXXXXX"
    val client_secret:String = "XXXXXXXXXXXXXXXXXXXXXXX"
    context.mount(new home(), "/*")
    context.mount(new auth_callback(keys,client_id,client_secret), "/callback/*")
    context.mount(new auth_playlist(keys,similar_tracks_ids), "/playlist/*")
    context.mount(new create_playlist(keys,similar_tracks_ids), "/create/*")
  }
}
