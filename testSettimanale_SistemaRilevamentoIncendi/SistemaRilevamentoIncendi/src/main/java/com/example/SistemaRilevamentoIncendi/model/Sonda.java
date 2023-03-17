package com.example.SistemaRilevamentoIncendi.model;

import com.example.SistemaRilevamentoIncendi.patterns.Observable;

public class Sonda extends Observable {
        private String id;
        private int smokeLevel;
        
        // Costruttore
        public Sonda(String string) {
            this.id = string;
            this.smokeLevel = 0;
        }
        
        public String getId() {
            return id;
        }
        
        public int getSmokeLevel() {
            return smokeLevel;
        }
        
        public void setSmokeLevel(int smokeLevel) {
            this.smokeLevel = smokeLevel;
            setChanged();
            notifyObservers();
        }

		private void setChanged() {
			// TODO Auto-generated method stub
			
		}

		public String getIdSonda() {
			// TODO Auto-generated method stub
			return null;
		}

		public void setFumo(int i) {
			// TODO Auto-generated method stub
			
		}

		public int getFumo() {
			// TODO Auto-generated method stub
			return 0;
		}

		public String getLatitude() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getLongitude() {
			// TODO Auto-generated method stub
			return null;
		}
    
	}
