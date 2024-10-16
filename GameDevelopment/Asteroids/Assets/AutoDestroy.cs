using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AutoDestroy : MonoBehaviour
// Lab 5 starter code
{
    // public float minLifetime, maxLifetime;
    public float minLifetime = 1f;
    public float maxLifetime = 3f;


    void Start()
    {
        StartCoroutine( HandleLifetime() );
    }

    private IEnumerator HandleLifetime()
    {
        yield return new WaitForSeconds(Random.Range(minLifetime, maxLifetime));
        Debug.Log("Fragment instantiated with lifetime between: " + minLifetime + " and " + maxLifetime);
        
        Debug.Log("Fragment destroyed");
        Destroy(gameObject);
    }
}