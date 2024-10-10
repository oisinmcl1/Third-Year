using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GameManager : MonoBehaviour {
	// Lab 4 solution starter code
	
	// inspector settings
	public GameObject asteroidPrefab;

	// class-level statics
	public static GameManager instance;
	public static int currentGameLevel;
	public static Vector3 screenBottomLeft, screenTopRight;
	public static float screenWidth, screenHeight;
	//

	// Use this for initialization
	void Start () {
		instance = this;
		Camera.main.transform.position = new Vector3 (0f, 30f, 0f);
		Camera.main.transform.LookAt (Vector3.zero, new Vector3 (0f, 0f, 1f));
		currentGameLevel = 0;

		StartNextLevel ();
	}

	public static void StartNextLevel() {
		currentGameLevel++;

		// find screen corners and size, in world coordinates
		// for ViewportToWorldPoint, the z value specified is in world units from the camera
		screenBottomLeft = Camera.main.ViewportToWorldPoint(new Vector3(0f,0f,30f));
		screenTopRight = Camera.main.ViewportToWorldPoint (new Vector3(1f,1f,30f));
		screenWidth = screenTopRight.x - screenBottomLeft.x;
		screenHeight = screenTopRight.z - screenBottomLeft.z;
		Debug.Log ("BottomLeft: "+screenBottomLeft);
		Debug.Log ("TopRight: "+screenTopRight);
		Debug.Log ("Width: " + screenWidth);
		Debug.Log ("Height: " + screenHeight);

		// create some asteroids near the edges of the screen
		for (int i = 0; i < currentGameLevel * 2 + 6; i++) {
			GameObject go = Instantiate (instance.asteroidPrefab) as GameObject;
			float x, z;
			if (Random.Range (0f, 1f) < 0.5f)
				x = screenBottomLeft.x + Random.Range (0f, 0.15f) * screenWidth; // near the left edge
			else
				x = screenTopRight.x - Random.Range (0f, 0.15f) * screenWidth; // near the right edge
			if (Random.Range (0f, 1f) < 0.5f)
				z = screenBottomLeft.z + Random.Range (0f, 0.15f) * screenHeight; // near the bottom edge
			else
				z = screenTopRight.z - Random.Range (0f, 0.15f) * screenHeight; // near the top edge
			go.transform.position = new Vector3(x, 0f, z);
		}
	}
}
