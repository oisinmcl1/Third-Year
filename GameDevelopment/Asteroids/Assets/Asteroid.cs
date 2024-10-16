using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Asteroid : MonoBehaviour
// Lab 5 starter code
{
    public Rigidbody rigidBody;
    
    void Start()
    {
        // randomise size+mass
        transform.localScale = new Vector3(Random.Range(0.08f, 0.12f), Random.Range(0.08f, 0.12f), Random.Range(0.08f, 0.12f));
        rigidBody.mass = transform.localScale.x * transform.localScale.y * transform.localScale.z;
        // randomise velocity
        rigidBody.velocity = new Vector3(Random.Range(-10f, 10f), 0f, Random.Range(-10f, 10f));
        rigidBody.angularVelocity = new Vector3(Random.Range(-4f, 4f), Random.Range(-4f, 4f), Random.Range(-4f, 4f));
    }

    
    private void OnCollisionEnter(Collision collision) {
        Debug.Log("Collision with " + collision.gameObject.name);
        
        float colSpeed = collision.relativeVelocity.magnitude;
        int num = Mathf.Clamp( Mathf.RoundToInt(colSpeed), 2, 8);
        
        for (int i=0; i<num; i++) {
            Debug.Log("Fragment spawned " + i);
            GameObject go = Instantiate(GameManager.instance.fragmentPrefab); 
            go.transform.position = collision.contacts[0].point;
            Rigidbody r = go.GetComponent<Rigidbody>();
            r.velocity = new Vector3 (Random.Range (-colSpeed, colSpeed), 0f, Random.Range (-colSpeed, colSpeed));
            r.angularVelocity = new Vector3 (Random.Range (-4f, 4f), Random.Range (-4f, 4f), Random.Range (-4f, 4f)); 
        }
    }
}