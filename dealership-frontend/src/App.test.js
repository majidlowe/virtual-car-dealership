import { render, screen } from '@testing-library/react';
import App from './App';



describe('the front page of a car lot application', function() {
  it('renders list of cars', () => {
    render(<App/>)
    expect(screen.getByText(/cruze/i)).toBeInTheDocument();

  });
  it('makes a car hidden from customer view', () => {
    render(<App/>)
    expect(screen.getByText(/cruze/i)).toBeInTheDocument();
    expect(screen.getByRole('heading', {name: /chevy/})

  });
})
