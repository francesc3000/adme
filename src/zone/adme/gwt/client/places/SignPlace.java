package zone.adme.gwt.client.places;

import com.google.gwt.place.shared.PlaceTokenizer;

public class SignPlace extends BasePlace
{
	private String signName;
	
	public SignPlace(String token)
	{
		this.signName = token;
	}

	public String getSignName()
	{
		return signName;
	}

	public static class Tokenizer implements PlaceTokenizer<SignPlace>
	{

		@Override
		public String getToken(SignPlace place)
		{
			return place.getSignName();
		}

		@Override
		public SignPlace getPlace(String token)
		{
			return new SignPlace(token);
		}

	}

	@Override
	public <IN, OUT> OUT accept(PlaceVisitor<IN, OUT> visitor, IN in) {
		return visitor.visit(this, in);
	}
}