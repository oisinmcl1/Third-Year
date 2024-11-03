using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ScreenEdgeChecker : MonoBehaviour
// Lab 5 Starter Code
{
    public Rigidbody rigidBody;
    
    void Start()
    {
        rigidBody = GetComponent<Rigidbody>();
        InvokeRepeating ("CheckScreenEdges", 0.1f, 0.1f);
    }

    private void CheckScreenEdges()
    {
        Vector3 pos = transform.position;
        Vector3 vel = rigidBody.velocity;
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