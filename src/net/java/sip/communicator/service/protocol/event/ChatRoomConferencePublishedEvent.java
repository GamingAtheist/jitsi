/*
 * Jitsi, the OpenSource Java VoIP and Instant Messaging client.
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */
package net.java.sip.communicator.service.protocol.event;

import net.java.sip.communicator.service.protocol.*;

import java.util.*;

/**
 * Dispatched to notify interested parties that a <tt>ChatRoomMember</tt> has
 * published a conference description.
 *
 * @author Boris Grozev
 */
public class ChatRoomConferencePublishedEvent
    extends EventObject
{
    /**
     * The <tt>ChatRoom</tt> which is the source of this event.
     */
    private final ChatRoom chatRoom;

    /**
     * The <tt>ChatRoomMember</tt> who published a
     * <tt>ConferenceDescription</tt>
     */
    private final ChatRoomMember member;

    /**
     * The <tt>ConferenceDescription</tt> that was published.
     */
    private final ConferenceDescription conferenceDescription;
    
    /**
     * The number of announced conference.
     */
    private final int activeConferencesCount;
    
    /**
     * The type of the event. It can be <tt>CONFERENCE_DESCRIPTION_SENT</tt> or 
     * <tt>CONFERENCE_DESCRIPTION_RECEIVED</tt>.
     */
    private final int eventType;
    
    /**
     * Event type that indicates sending of conference description by the local 
     * user.
     */
    public final static int CONFERENCE_DESCRIPTION_SENT = 0;
    
    /**
     * Event type that indicates receiving conference description.
     */
    public final static int CONFERENCE_DESCRIPTION_RECEIVED = 1;

    /**
     * Creates a new instance.
     * @param chatRoom The <tt>ChatRoom</tt> which is the source of this event.
     * @param member The <tt>ChatRoomMember</tt> who published a
     * <tt>ConferenceDescription</tt>
     * @param conferenceDescription The <tt>ConferenceDescription</tt> that was
     * published.
     * @param activeConferencesCount the number of announced conference.
     */
    public ChatRoomConferencePublishedEvent(
            int eventType,
            ChatRoom chatRoom,
            ChatRoomMember member,
            ConferenceDescription conferenceDescription,
            int activeConferencesCount)
    {
        super(chatRoom);
        
        this.eventType = eventType;
        this.chatRoom = chatRoom;
        this.member = member;
        this.conferenceDescription = conferenceDescription;
        this.activeConferencesCount = activeConferencesCount;
    }

    /**
     * Returns the <tt>ChatRoom</tt> which is the source of this event.
     * @return the <tt>ChatRoom</tt> which is the source of this event.
     */
    public ChatRoom getChatRoom()
    {
        return chatRoom;
    }

   /**
    * Returns the <tt>ChatRoomMember</tt> who published a
    * <tt>ConferenceDescription</tt>
    * @return the <tt>ChatRoomMember</tt> who published
    * a <tt>ConferenceDescription</tt>
    */
    public ChatRoomMember getMember()
    {
        return member;
    }

    /**
     * Returns the <tt>ConferenceDescription</tt> that was published.
     * @return the <tt>ConferenceDescription</tt> that was published.
     */
    public ConferenceDescription getConferenceDescription()
    {
        return conferenceDescription;
    }
    
    /**
     * Returns the number of announced conferences.
     * @return the number of announced conferences.
     */
    public int getActiveConferencesCount()
    {
        return activeConferencesCount;
    }
    
    /**
     * Returns the event type.
     * @return the event type.
     */
    public int getType()
    {
        return eventType;
    }
}
