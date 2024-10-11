import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

import FavouriteColour from "./FavouriteColour.jsx";
import Welcome from "./Greet.jsx";
import Frag from "./Fragments.jsx";

function App() {
  const [count, setCount] = useState(0)

  return (
      <>
          <div>
              <a href="https://vitejs.dev" target="_blank">
                  <img src={viteLogo} className="logo" alt="Vite logo"/>
              </a>
              <a href="https://react.dev" target="_blank">
                  <img src={reactLogo} className="logo react" alt="React logo"/>
              </a>
          </div>
          <h1>This is my new app</h1>
          <div className="card">
              <button onClick={() => setCount((count) => count + 1)}>
                  count is {count}
              </button>
              <p>
                  Edit <code>src/App.jsx</code> and save to test HMR
              </p>
          </div>
          <p className="read-the-docs">
              Click on the Vite and React logos to learn more
          </p>

          <br></br>
          <br></br>
          <br></br>
          <div>
              <h3>Favourite Colour</h3>
              <FavouriteColour/>
          </div>

          <div>
              <h3>Greeting</h3>
              <Welcome name="Oisín"/>
          </div>

          <div>
              <h3>Fragment</h3>
              <Frag/>
          </div>

          <br></br>
      </>
  )
}

export default App
