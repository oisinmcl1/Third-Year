using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Spaceship : MonoBehaviour
{
    private Rigidbody rb;
    
    // Start is called before the first frame update
    void Start()
    {
        rb = GetComponent<Rigidbody>();
    }

    // Update is called once per frame
    void Update()
    {
        // Move spaceship forward if front arrow key pressed using physics
        if (Input.GetKey(KeyCode.UpArrow))
        {
            rb.AddForce(transform.forward * 4f);
        }
        
        // Rotate spaceship left if left arrow key pressed using physics
        if (Input.GetKey(KeyCode.LeftArrow))
        {
            rb.AddTorque(Vector3.up * -2f);
        }
        
        // Rotate spaceship right if right arrow key pressed using physics
        if (Input.GetKey(KeyCode.RightArrow))
        {
            rb.AddTorque(Vector3.up * 2f);
        }
        
        // Call CheckScreenEdges every 0.2 seconds using invoke repeating
        InvokeRepeating("CheckScreenEdges", 0.2f, 0.2f);
    }
    
    // Implement screen wrapping for spaceship the same way it was done for asteroids
    void CheckScreenEdges()
    {
        Vector3 pos = transform.position;
        Vector3 vel = rb.velocity;
        float xTeleport = 0f, zTeleport = 0f;
        
        if (pos.x < GameManager.screenBottomLeft.x && vel.x <= 0f)
        {
            xTeleport = GameManager.screenWidth;
        }
        else if (pos.x > GameManager.screenTopRight.x && vel.x >= 0f)
        {
            xTeleport = -GameManager.screenWidth;
        }
        
        if (pos.z < GameManager.screenBottomLeft.z && vel.z <= 0f)
        {
            zTeleport = GameManager.screenHeight;
        }
        else if (pos.z > GameManager.screenTopRight.z && vel.z >= 0f)
        {
            zTeleport = -GameManager.screenHeight;
        }
        
        if (xTeleport != 0f || zTeleport != 0f)
        {
            transform.position = new Vector3(pos.x + xTeleport, 0f, pos.z + zTeleport);
        }
    }
}
