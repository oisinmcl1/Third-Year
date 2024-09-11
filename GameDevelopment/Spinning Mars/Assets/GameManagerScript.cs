using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GameManagerScript : MonoBehaviour
{
	public GameObject mars;

    // Start is called before the first frame update
    void Start()
    {
    	Camera.main.transform.position = new Vector3(0f, 0f, -100f);
    	Camera.main.transform.LookAt(mars.transform);

    	mars.GetComponent<Rigidbody>().AddTorque(new Vector3(0f, 10f, 0f));
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
