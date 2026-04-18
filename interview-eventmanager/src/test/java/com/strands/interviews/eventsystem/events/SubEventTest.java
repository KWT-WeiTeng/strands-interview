package com.strands.interviews.eventsystem.events;

import com.strands.interviews.eventsystem.EventListenerMock;
import com.strands.interviews.eventsystem.EventManager;
import com.strands.interviews.eventsystem.impl.DefaultEventManager;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SubEventTest {

    private final EventManager eventManager = new DefaultEventManager();

    @Test
    public void testSimpleEventListenerDoesNotReceiveSubEventNotification() {
        EventListenerMock simpleEventListener = new EventListenerMock(new Class[]{SimpleEvent.class});
        eventManager.registerListener("simpleEvent.key", simpleEventListener);
        eventManager.publishEvent(new SubEvent(this));
        assertEquals(0, simpleEventListener.count);
        assertFalse(simpleEventListener.isCalled());
    }

    @Test
    public void testSubEventListenerDoesNotReceiveSimpleEventNotification() {
        EventListenerMock subEventListener = new EventListenerMock(new Class[]{SubEvent.class});
        eventManager.registerListener("subEvent.key", subEventListener);
        eventManager.publishEvent(new SimpleEvent(this));
        assertEquals(0, subEventListener.count);
        assertFalse(subEventListener.isCalled());
    }

    @Test
    public void testSubEventListenerReceivesSubEventNotification() {
        EventListenerMock subEventListener = new EventListenerMock(new Class[]{SubEvent.class});
        eventManager.registerListener("subEvent2.key", subEventListener);
        eventManager.publishEvent(new SubEvent(this));
        assertEquals(1, subEventListener.count);
        assertTrue(subEventListener.isCalled());
    }
}
