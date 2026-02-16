import { useState } from "react";
import { generateInterviewQuestion } from "../services/aiService";

export default function Home() {
  const [topic, setTopic] = useState("");
  const [difficulty, setDifficulty] = useState("easy");
  const [question, setQuestion] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleGenerate = async () => {
    if (!topic.trim()) {
      setError("Please enter a topic");
      return;
    }

    setLoading(true);
    setError("");
    setQuestion("");

    try {
      const generatedQuestion = await generateInterviewQuestion(
        topic,
        difficulty
      );
      setQuestion(generatedQuestion);
    } catch (err) {
      setError("Failed to generate question. Try again.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="container">
      <h1>AI Interview Question Generator</h1>

      <input
        type="text"
        placeholder="Enter topic (e.g. Java, DSA)"
        value={topic}
        onChange={(e) => setTopic(e.target.value)}
      />

      <select
        value={difficulty}
        onChange={(e) => setDifficulty(e.target.value)}
      >
        <option value="easy">Easy</option>
        <option value="medium">Medium</option>
        <option value="hard">Hard</option>
      </select>

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
  );
}
