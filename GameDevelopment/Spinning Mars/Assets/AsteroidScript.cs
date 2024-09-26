using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SocialPlatforms;

public class AsteroidScript : MonoBehaviour {
    public GameObject mars;
    
    // Start is called before the first frame update
    void Start() {
        // Spawn asteroid to the left of mars
        transform.position = new Vector3(Random.Range(-100f, -250f), Random.Range(-250f, 250f), mars.transform.position.z);
        // transform.position = new Vector3(mars.transform.position.x - 100f , mars.transform.position.y + 60f, mars.transform.position.z);

        // Add force to the asteroid to move it to the right, ForceMode.Impulse is used to apply the force instantly
        GetComponent<Rigidbody>().AddForce((mars.transform.position - transform.position).normalized * 30f, ForceMode.Impulse);
        // GetComponent<Rigidbody>().AddForce(Vector3.right * 30f, ForceMode.Impulse);
    }

    // Update is called once per frame
    void Update() {
        // Check if asteroid is off screen, if so destroy it!
        Vector3 screenPos = Camera.main.WorldToScreenPoint(transform.position);
        if (screenPos.x < -300f || screenPos.x > Screen.width + 300f || screenPos.y < -300f || screenPos.y > Screen.height + 300f) {
            Destroy(gameObject);
        }
    }
    
    // If asteroid collides with anything (apart from itself!), blow it up
    void OnTriggerEnter(Collider other) {
        if (other.gameObject.CompareTag("mars")) {
            Destroy(gameObject);   
        }
    }
}
