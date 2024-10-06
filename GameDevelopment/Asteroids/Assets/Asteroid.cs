using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class NewBehaviourScript : MonoBehaviour
{
    private Vector3 screenBounds;
    
    // Start is called before the first frame update
    void Start()
    {
        // Generate random direction for asteroid
        Vector3 randDir = new Vector3(Random.Range(-1f, 1f), 0, Random.Range(-1f, 1f));

        // Normalize so asteroid moves constant direction
        randDir.Normalize();
        
        // Randomize asteroid velocity
        float randVel = Random.Range(1f, 3f);
        
        // Set asteroid velocity
        GetComponent<Rigidbody>().AddForce(randDir * randVel, ForceMode.Impulse);
        
        // Calculate screenbounds from where camera is looking
        screenBounds = Camera.main.ViewportToWorldPoint(new Vector3(1, 1, Camera.main.transform.position.y));
    }
    
    private float timeAccumulator = 0;
    
    // Update is called once per frame
    void Update()
    {
        // Add time passed since last frame
        timeAccumulator += Time.deltaTime;
        
        // If 0.2 seconds have passed, call CheckBounds (in theory this is 5 times a second)
        if (timeAccumulator >= 0.2f) {
            CheckBounds();
            timeAccumulator = 0;
        }
    }

    void CheckBounds()
    {
        Vector3 pos = transform.position;
        
        // Wrap asteroid around screen if it goes out of bounds
        if (pos.x > screenBounds.x) {
            pos.x = -screenBounds.x;
        }
        else if (pos.x < -screenBounds.x) {
            pos.x = screenBounds.x;
        }
        
        if (pos.z > screenBounds.z) {
            pos.z = -screenBounds.z;
        }
        else if (pos.z < -screenBounds.z) {
            pos.z = screenBounds.z;
        }
        
        // Set new position of the wrapped asteroid
        transform.position = pos;
    }
}
