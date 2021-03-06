var common;

(function(common) {
	var alerts;
	
	(function(alerts) {		
		alerts.ErrorSelector = ErrorSelector;
		alerts.info = info;
		alerts.error = error;
		alerts.warning = warning;
		
		function info(message) {
			return {type: 'info', message: message};
		}
		
		function error(message) {
			return {type: 'danger', message: message};
		}
		
		function warning(message) {
			return {type: 'warning', message: message};
		}
		
		function ErrorSelector() {		
			var messages = {};
			var defaultMessage = "unexpected error";
			
			this.select = select;
			this.when = when;

			function select(status) {
				var message = messages[status];
				
				if (!message) {
					return error(defaultMessage);
				}
											
				return error(message);			
			}

			function when(status, message) {
				messages[status] = message;
				return this;
			}
			
			function defaultMsg(message) {
				defaultMessage = message;
				return this;
			}	
		}	
		
	})(alerts = common.alerts || (common.alerts = {}));
})(common || (common = {}));