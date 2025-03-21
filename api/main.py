from fastapi import FastAPI
from pydantic import BaseModel
from chatbot.chatbot import chatbot  # Import chatbot instance

app = FastAPI()

class Query(BaseModel):
    message: str

@app.post("/chat")
async def chat(query: Query):
    response = chatbot.get_response(query.message)
    return {"response": response}

# Run using: uvicorn api.main:app --reload
