document.getElementById('loginForm')?.addEventListener('submit', async (e) => {
  e.preventDefault();

  const user = {
    username: document.getElementById('username').value,
    password: document.getElementById('password').value,
    role: document.getElementById('role').value
  };

  const res = await fetch('http://localhost:8080/school/login', {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(user)
  });

  if (res.ok) {
    const data = await res.json();
    alert('Login Successful!');
    window.location.href = `dashboard.html?role=${data.role}`;
  } else {
    alert('Invalid credentials');
  }
});
