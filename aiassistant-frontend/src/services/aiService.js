const API_BASE_URL = import.meta.env.VITE_API_BASE_URL;

export async function generateInterviewQuestion(topic, difficulty) {
  const response = await fetch(
    `${API_BASE_URL}/api/ai/interview-question`,
    {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ topic, difficulty }),
    }
  );

  if (!response.ok) {
    const errorText = await response.text();
    throw new Error(errorText || "Failed to generate question");
  }

  const result = await response.json();
  return result?.data?.question || "No question generated";
}