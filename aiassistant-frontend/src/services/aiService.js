const API_BASE_URL = "http://localhost:8080/api/ai";

/**
 * Generate an AI interview question
 * @param {string} topic
 * @param {string} difficulty
 * @returns {Promise<string>} Generated question
 */
export async function generateInterviewQuestion(topic, difficulty) {
  const response = await fetch(`${API_BASE_URL}/interview-question`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      topic,
      difficulty,
    }),
  });

  if (!response.ok) {
    const errorText = await response.text();
    throw new Error(errorText || "Failed to generate question");
  }

  const result = await response.json();

  // Backend contract: { success, message, data: { question } }
  return result?.data?.question || "No question generated";
}
