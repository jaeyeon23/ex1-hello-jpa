import threading
import cantools
import serial

class CanSerial:
    def __init__(self):
        self._db = cantools.db.load_file('test.dbc')

        self.serial = serial.Serial(
            port='Port',     
            baudrate=50000,   
            parity=serial.PARITY_NONE,
            stopbits=serial.STOPBITS_ONE,
            bytesize=serial.EIGHTBITS,
            timeout=1        
        )

        # self.serial.open()

        is_open = self.serial.is_open

        print(f'is open? {is_open}')

        if is_open:
            thread = threading.Thread(target=self.read_data)
            thread.start()
    
    def read_data(self):
        while True:
            message = self.serial.readline()
            print(message)


if __name__ == "__main__":
    peakCanSerial = PeakCanSerial()