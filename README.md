# AI Study & Interview Assistant
## 📌 Project Description

AI Study & Interview Assistant is an AI-powered web application designed to help students prepare for technical interviews and improve their study process.

The system generates interview questions, explanations, and study materials using Large Language Models (LLMs). It is designed to be LLM-independent, allowing integration with multiple AI providers such as OpenAI and Google Gemini.

The application is built using Spring Boot for the backend and React + Vite for the frontend, with MongoDB Atlas for database storage.

## 🚀 Features

- AI-generated technical interview questions
- Study assistance for multiple subjects
- LLM-independent architecture
- Support for OpenAI and Google Gemini APIs
- Fast and responsive UI
- Secure backend with Spring Boot
- Cloud database using MongoDB Atlas

## 🌐 Live Deployment

Access the live application here:
- **Frontend (Vercel)**: https://ai-study-assistant-tan.vercel.app/
- **Backend API (Railway)**: https://ai-study-assistant-interview-questions.up.railway.app
- **Railway Dashboard**: https://railway.com/project/553dc746-17ee-44cd-a211-0c9858d280b3
- **Local Development**: http://localhost:5173/ (with local backend on http://localhost:8080)

## 🛠 Tech Stack

### Frontend
- React
- Vite
- HTML
- CSS
- JavaScript

### Backend
- Spring Boot
- Java
- REST APIs

### Database
- MongoDB Atlas

### AI Models
- OpenAI API
- Google Gemini API

## 🏗 System Architecture

User → React Frontend → Spring Boot Backend → AI API (OpenAI / Gemini) → MongoDB Atlas

## ⚙️ Installation & Setup

### 📦 Prerequisites
- Java 17+
- Node.js & npm
- MongoDB (local or MongoDB Atlas)
- Google Gemini API key (or OpenAI API key)

### 🖥️ Local Development Setup

#### Backend Setup
1. Navigate to the backend directory:
```bash
cd aiassistant
```

2. Build the project:
```bash
./mvnw.cmd clean package -DskipTests
```

3. Start the backend server:
```bash
java -jar target/aiassistant-0.0.1-SNAPSHOT.jar
```
The backend will run on `http://localhost:8080`

#### Frontend Setup
1. Navigate to the frontend directory:
```bash
cd aiassistant-frontend
```

2. Install dependencies:
```bash
npm install
```

3. Start the development server:
```bash
npm run dev
```
The frontend will run on `http://localhost:5173`

#### Environment Configuration
- **Local Development**: The frontend automatically uses `.env.local` which points to `http://localhost:8080`
- **Production**: The frontend uses `.env` which points to the Railway backend URL

### 🚀 Deployment on Railway

1. Push your code to GitHub
2. Connect your GitHub repository to Railway
3. Set the following environment variables in Railway:
   - `MONGODB_URI` - Your MongoDB connection string
   - `MONGODB_DATABASE` - Your database name
   - `GEMINI_API_KEY` - Your Google Gemini API key
   - `PORT` - Default is 8080

4. Railway will automatically build and deploy your application

The deployed frontend will use `.env` and connect to your Railway backend.

### 🔧 CORS Configuration

The backend is configured to accept requests from:
- Local development: `http://localhost:5173`
- Railway deployments: `https://*.railway.app`
- Vercel deployments: `https://*.vercel.app`

All HTTP methods (GET, POST, PUT, DELETE, PATCH, OPTIONS) are supported.

## � Troubleshooting

### CORS Error on Vercel/Production
If the deployed Vercel app shows CORS errors:
1. The Railway backend needs to be redeployed with the latest CORS configuration
2. Push changes to GitHub and Railway will auto-deploy
3. Verify Railway backend is running: https://railway.com/project/553dc746-17ee-44cd-a211-0c9858d280b3
4. Wait a few minutes for Railway to rebuild and restart

### CORS Error Locally
If you see a CORS error in the browser console:
1. Ensure the backend server is running on `http://localhost:8080`
2. Check that `.env.local` points to `http://localhost:8080`
3. Refresh the browser to clear cache


### Build Failures
If Maven build fails:
1. Ensure Java 17+ is installed
2. Run: `./mvnw.cmd clean package -DskipTests`
3. Check for any syntax errors in source code

## 🔮 Future Improvements
- JWT Authentication
- Mock interview simulation
- User profiles and progress tracking
- Multiple language support
- Advanced caching strategies

