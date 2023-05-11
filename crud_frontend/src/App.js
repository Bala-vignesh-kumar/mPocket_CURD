import './App.css';
import { Dashboard } from './Component/Dashboard';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { AddContact } from './Component/AddContact';

function App() {
return(
<div>
  <Router>
    <Routes>
      <Route exact path="/" element={<Dashboard />} />
      <Route path="/AddContact" element={<AddContact />} />
    </Routes>
  </Router>
</div>
)
}

export default App;