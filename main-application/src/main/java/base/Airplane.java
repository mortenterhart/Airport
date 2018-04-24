package base;

// TODO: base class -> durch richtige Airplane Klasse ersetzen

import com.google.common.eventbus.EventBus;
import event.Subscriber;
import section.Body;
import section.Wing;

public class Airplane {
    private EventBus eventBus;
    private Body body;
    private Wing leftWing;
    private Wing rightWing;

    public Airplane() {
        eventBus = new EventBus("EB-A380");
    }

    public Body getBody() {
        return body;
    }

    public Wing getLeftWing() {
        return leftWing;
    }

    public Wing getRightWing() {
        return rightWing;
    }

    public void addSubscriber(Subscriber subscriber) {
        eventBus.register(subscriber);
    }

    public void build() {
        body = new Body();
        addSubscriber(body);

        leftWing = new Wing(0);
        addSubscriber(leftWing);

        rightWing = new Wing(1);
        addSubscriber(rightWing);
    }

}
