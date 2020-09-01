package eva.recipes.chapter5Reactive4.echo;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;


public class EchoHandler implements WebSocketHandler {

    @Override
    public Mono<Void> handle(WebSocketSession webSocketSession) {
        return webSocketSession.send(
                webSocketSession.receive()
                .map( msg -> "RECEIVED:" + msg.getPayloadAsText())
                .map(webSocketSession::textMessage)
        );
    }
}
