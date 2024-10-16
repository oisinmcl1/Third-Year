using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Bullet : MonoBehaviour
{
    public Rigidbody rb;

    // Start is called before the first frame update
    void Start()
    {
        rb = GetComponent<Rigidbody>();

        // Fire bullet in the direction it is facing
        rb.velocity = transform.forward * 10f;

        // Check if bullet off screen, if so destroy it using function
        InvokeRepeating("CheckScreenEdges", 0.1f, 0.1f);
    }

    // Update is called once per frame
    void Update()
    {
    }

    // Destroy bullet if off screen (using modiefied ScreenEdgeChecker.cs)
    private void CheckScreenEdges()
    {
        Vector3 pos = transform.position;

        if (pos.x < GameManager.screenBottomLeft.x)
        {
            Destroy(gameObject);
        }

        else if (pos.x > GameManager.screenTopRight.x)
        {
            Destroy(gameObject);
        }

        if (pos.z < GameManager.screenBottomLeft.z)
        {
            Destroy(gameObject);
        }

        else if (pos.z > GameManager.screenTopRight.z)
        {
            Destroy(gameObject);
        }
    }
}
