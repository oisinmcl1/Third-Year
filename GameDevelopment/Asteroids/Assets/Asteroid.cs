using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Asteroid : MonoBehaviour {
    // Lab 4 solution starter code
    
    // inspector settings
    public Rigidbody rigidBody;
    //

    // Use this for initialization
    void Start () {
        // randomise size+mass
        transform.localScale = new Vector3(Random.Range(0.06f,0.09f), Random.Range(0.06f,0.09f), Random.Range(0.06f,0.09f));
        rigidBody.mass = transform.localScale.x * transform.localScale.y * transform.localScale.z;

        // randomise velocity
        rigidBody.velocity = new Vector3 (Random.Range (-10f, 10f), 0f, Random.Range (-10f, 10f));
        rigidBody.angularVelocity = new Vector3 (Random.Range (-4f, 4f), Random.Range (-4f, 4f), Random.Range (-4f, 4f));
	
        // start periodically checking for being off-screen
        InvokeRepeating ("CheckScreenEdges", 0.2f, 0.2f);
    }
	
    private void CheckScreenEdges() {
        Vector3 pos = transform.position; 
        Vector3 vel = rigidBody.velocity; 
        float xTeleport = 0f, zTeleport = 0f;

        if (pos.x < GameManager.screenBottomLeft.x && vel.x <= 0f)  // velocity check as sanity test
            xTeleport = GameManager.screenWidth;
        else if (pos.x > GameManager.screenTopRight.x && vel.x >= 0f)
            xTeleport = -GameManager.screenWidth;

        if (pos.z < GameManager.screenBottomLeft.z && vel.z <= 0f)
            zTeleport = GameManager.screenHeight;
        else if (pos.z > GameManager.screenTopRight.z && vel.z >= 0f)
            zTeleport = -GameManager.screenHeight;

        if (xTeleport != 0f || zTeleport != 0f)
            transform.position = new Vector3 (pos.x + xTeleport, 0f, pos.z + zTeleport);
    }
}