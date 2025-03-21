import spacy

class Chatbot:
    def __init__(self):
        self.nlp = spacy.load("en_core_web_sm")

    def get_response(self, text):
        doc = self.nlp(text.lower())
        if "hello" in text:
            return "Hello! How can I help you?"
        elif "bye" in text:
            return "Goodbye! Have a great day."
        else:
            return "I'm not sure how to respond to that."

chatbot = Chatbot()
