using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Debris : MonoBehaviour
{
    public GameObject debrisPrefab;
    public int debrisCount = 3;
    
    // Start is called before the first frame update
    void Start()
    {
    }

    // Update is called once per frame
    void Update()
    {
    }

    // Triggered when asteroid collides with another object
    void OnTriggerEnter(Collider other)
    {
        Debug.Log("Asteroid hit something");
        
        // Spawn debris
        SpawnFragments(transform.position);
        
        // Disable the collider to prevent more triggers (I kept crashing unity)
        GetComponent<Collider>().enabled = false;
        
        // Destroy asteroid
        Destroy(gameObject);
    }
    
    // Spawn the debris
    void SpawnFragments(Vector3 position)
    {
        for (int i = 0; i < debrisCount; i++)
        {
            // Instantiate debris with random rotation at the position of the asteroid
            GameObject debris = Instantiate(debrisPrefab, position, Random.rotation);
            
            // Add force randomly to the debris
            Rigidbody rb = debris.GetComponent<Rigidbody>();
            rb.AddForce(new Vector3(Random.Range(-1f, 1f), 0 , Random.Range(-1f, 1f)) * 2f, ForceMode.Impulse);
            
            Destroy(debris, 2f);
        }
    }
}
