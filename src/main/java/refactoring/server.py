import socket

def start_server():
    host = 'localhost'  # Indirizzo del server (localhost)
    port = 2017         # Porta su cui ascoltare

    # Creazione del socket
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.bind((host, port))  # Associa il socket all'indirizzo e alla porta
    server_socket.listen(5)          # Ascolta fino a 5 connessioni in coda

    print(f"Server in ascolto su {host}:{port}...")

    while True:
        # Accetta una connessione
        client_socket, addr = server_socket.accept()
        print(f"Connessione accettata da {addr}")

        # Invia un messaggio al client
        client_socket.sendall(b"Chiave1 Valore1\nChiave2 Valore2\n")
        print("Dati inviati al client.")

        # Chiudi la connessione con il client
        client_socket.close()

if __name__ == "__main__":
    start_server()
