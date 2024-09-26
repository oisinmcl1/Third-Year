using System.Collections;
using System.Collections.Generic;
using System.Numerics;
using UnityEngine;
using Vector3 = UnityEngine.Vector3;

public class GameManagerScript : MonoBehaviour {
	// Create GameObjects for mars, phobos, and deimos
	public GameObject mars;
	public GameObject phobos;
	public GameObject deimos;
	public GameObject asteroid;
	public int total = 0;

    // Start is called before the first frame update
    void Start() {
	    // Position camera to face mars
    	Camera.main.transform.position = new Vector3(0f, 0f, -150f);
	    Camera.main.transform.LookAt(mars.transform);
	    
	    // mars.transform.position = new Vector3(0f, 0f, 0f);
	    // phobos.transform.position = new Vector3(75f, 0f, 0f);
	    // deimos.transform.position = new Vector3(100f, 0f, 0f);
	    // mars.GetComponent<Rigidbody>().AddTorque(new Vector3(0f, 10f, 0f));
    }

    // Update is called once per frame
    void Update() {
	    // Rotate mars around its y-axis programmatically by 10 degrees per second
	    mars.transform.Rotate(new Vector3(0F, 10f * Time.deltaTime, 0f), Space.World);
	    
	    // Rotate phobos and deimos around mars
	    phobos.transform.RotateAround(mars.transform.position, Vector3.up, 10f * Time.deltaTime);
	    deimos.transform.RotateAround(mars.transform.position, Vector3.up, 15f * Time.deltaTime);
	    
	    // Rotate camera around mars using arrow keys
	    // Left or Right arrow keys rotating the camera round mars y-axis
	    if (Input.GetKey(KeyCode.LeftArrow))
		    Camera.main.transform.RotateAround(mars.transform.position, Camera.main.transform.up, 20f * Time.deltaTime);
	    else if (Input.GetKey(KeyCode.RightArrow))
		    Camera.main.transform.RotateAround(mars.transform.position, Camera.main.transform.up, -20f * Time.deltaTime);
	    
	    // Up or Down arrow keys rotating the camera around mars x-axis
	    if (Input.GetKey(KeyCode.UpArrow))
		    Camera.main.transform.RotateAround(mars.transform.position, Camera.main.transform.right, 20f * Time.deltaTime);
	    else if (Input.GetKey(KeyCode.DownArrow))
		    Camera.main.transform.RotateAround(mars.transform.position, Camera.main.transform.right, -20f * Time.deltaTime);

	    // Ensure camera still looks at mars after rotating
	    // Camera.main.transform.LookAt(mars.transform);
	    
	    
	    // Spawn Asteroids randomly, 0.2% chance of spawning per frame
	    if (Random.Range(0f, 100f) < 0.2f) {
		    Instantiate(asteroid);
		    total++;
		    Debug.Log("Asteroid Spawned!\nToal Asteroids: " + total);
	    }
    }
}
