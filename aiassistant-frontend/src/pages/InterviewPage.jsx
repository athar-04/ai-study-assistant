import { useState } from "react";
import { generateInterviewQuestion } from "../services/aiService";

function InterviewPage() {
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
      setError("⚠️ AI is busy right now. Please try again.");
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
            value={topic}
            onChange={(e) => setTopic(e.target.value)}
            placeholder="e.g. Java, React, SQL"
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
          {loading ? "🧠 AI is thinking..." : "Generate Question"}
        </button>

        {error && <p className="error fade-in">{error}</p>}

        {question && (
          <div className="result fade-in">
            <h3>Generated Question</h3>
            <p>{question}</p>
          </div>
        )}
      </div>
    </div>
  );
}

export default InterviewPage;
