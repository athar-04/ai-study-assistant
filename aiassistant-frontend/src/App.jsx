import { useState } from "react";
import { generateInterviewQuestion } from "./services/aiService";
import "./index.css";

function App() {
  const [topic, setTopic] = useState("Java");
  const [difficulty, setDifficulty] = useState("medium");
  const [question, setQuestion] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleGenerate = async () => {
    setLoading(true);
    setError("");
    setQuestion("");

    try {
      const result = await generateInterviewQuestion(topic, difficulty);
      setQuestion(result);
    } catch (err) {
      setError("Failed to generate question. Please try again.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="app-container">
      <div className="card">
        <h1>AI Interview Question Generator</h1>

        <div className="form-group">
          <label>Topic</label>
          <input
            type="text"
            value={topic}
            onChange={(e) => setTopic(e.target.value)}
            placeholder="e.g. Java, Spring Boot, React"
          />
        </div>

        <div className="form-group">
          <label>Difficulty</label>
          <select
            value={difficulty}
            onChange={(e) => setDifficulty(e.target.value)}
          >
            <option value="easy">Easy</option>
            <option value="medium">Medium</option>
            <option value="hard">Hard</option>
          </select>
        </div>

        <button onClick={handleGenerate} disabled={loading}>
          {loading ? "Generating..." : "Generate Question"}
        </button>

        {error && <p className="error">{error}</p>}

        {question && (
          <div className="result">
            <h3>Generated Question</h3>
            <p>{question}</p>
          </div>
        )}
      </div>
    </div>
  );
}

export default App;
