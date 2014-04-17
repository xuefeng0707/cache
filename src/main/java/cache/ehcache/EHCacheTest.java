package cache.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EHCacheTest {

	// http://terracotta.org/downloads/open-source/catalog
	public static void main(String[] args) {
		CacheManager manager = CacheManager.create(Thread.currentThread().getContextClassLoader().getResourceAsStream("cache/ehcache/ehcache.xml"));
		manager.addCache("hello");
		
		Cache cache =  manager.getCache("hello");
		cache.put(new Element("1", 11));
		
		Cache tcache = manager.getCache("sampleTerracottaCache");
		tcache.put(new Element("2",22));
		
		System.out.println(cache.get("1"));
		System.out.println(tcache.get("2"));
	}

}
