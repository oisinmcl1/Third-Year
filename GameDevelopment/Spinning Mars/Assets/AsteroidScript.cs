using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AsteroidScript : MonoBehaviour {
    public GameObject mars;
    
    // Start is called before the first frame update
    void Start() {
        // Spawn asteroid to the left of mars
        transform.position = new Vector3(-100f, 0f, 0f);

        // Add force to the asteroid to move it to the right, ForceMode.Impulse is used to apply the force instantly
        GetComponent<Rigidbody>().AddForce((mars.transform.position - transform.position).normalized * 15f, ForceMode.Impulse);
    }

    // Update is called once per frame
    void Update() {
    }
    
    // If asteroid collides with anything, blow it up
    void OnTriggerEnter(Collider other) {
        Destroy(gameObject);
    }
}
