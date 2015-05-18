package test.com.nosolojava.omnichannel.omnisession.listener;

import org.infinispan.notifications.Listener;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryCreated;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryModified;
import org.infinispan.notifications.cachelistener.event.CacheEntryCreatedEvent;
import org.infinispan.notifications.cachelistener.event.CacheEntryModifiedEvent;
import org.infinispan.notifications.cachemanagerlistener.annotation.ViewChanged;
import org.infinispan.notifications.cachemanagerlistener.event.ViewChangedEvent;

import com.nosolojava.omnichannel.omnisession.dto.OmnisessionUserInstance;

@Listener(clustered = true)
public class UserInfoChangeLoggerListener {

	@ViewChanged
	public void viewChanged(ViewChangedEvent event) {
		System.out.printf("view changed: %s", event);
	}

	@CacheEntryCreated
	public void entryCreated(CacheEntryCreatedEvent<String, OmnisessionUserInstance> event) {

		System.out.printf("New user created: %s", event);
	}

	@CacheEntryModified
	public void entryModified(CacheEntryModifiedEvent<String, OmnisessionUserInstance> event) {

		System.out.printf("User modified: %s", event);
	}
}
