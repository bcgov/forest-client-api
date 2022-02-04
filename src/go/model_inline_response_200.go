/*
 * Forest Client API
 *
 * This is a simple API to retrieve information about Forest Clients
 *
 * API version: 1.0.0
 * Contact: c.gustafson@cgi.com
 * Generated by: Swagger Codegen (https://github.com/swagger-api/swagger-codegen.git)
 */
package swagger
import (
	"time"
)

type InlineResponse200 struct {
	// A list of forest client representations
	Data []ForestClient `json:"data,omitempty"`
	// The timestamp when the search was run (for caching)
	CacheTime time.Time `json:"cache_time,omitempty"`
}
